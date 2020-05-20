# app.rb
require 'json'

require 'sinatra'


set :public_folder, File.dirname(__FILE__) + '/static'

configure do
    set :bind, '0.0.0.0'
    set :port, '4567'
end
  
#前置过滤器
before do
    puts 'before process'
end

#后置过滤器
after do
    puts 'after process'
end

#找不到页面调用的逻辑
not_found do
    '<h1>404 you know!</h1>'
end
 
  
get '/' do
  'Hello world!'
end

get '/test' do
    erb :test
end

#渲染views/success.erb模板
post '/submit' do
    @email = 'hr@163.com'
    @email2 = params['email']
    @url = request.url
    erb :success
end

get '/health' do
    content_type :json
    {:status => "UP"}.to_json
end

get '/getUser' do
    content_type :json
    {:username => "ruby", :password => "ruby"}.to_json
end

