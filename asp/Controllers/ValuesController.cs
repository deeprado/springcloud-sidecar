using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace asp.Controllers
{
    [Route("/[controller]")]
    [ApiController]
    public class HealthController : ControllerBase
    {
        // GET /health
        [HttpGet]
        public JsonResult Get()
        {
            var stat = new {
              status = "UP"
            };
            return new JsonResult(stat);
        }
    }

    [Route("/getUser")]
    [ApiController]
    public class UserController : ControllerBase
    {
        // GET /health
        [HttpGet]
        public JsonResult Get()
        {
            var u = new {
              username = "asp",
              password = "asp"
            };
            return new JsonResult(u);
        }
    }

    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        // GET api/values
        [HttpGet]
        public ActionResult<IEnumerable<string>> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult<string> Get(int id)
        {
            return "value";
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
