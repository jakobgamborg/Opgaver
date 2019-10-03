using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MyCV.Models;

namespace MyCV.Controllers
{
    public class CvsController : Controller
    {
        private readonly MyCVContext _context;

        public CvsController(MyCVContext context)
        {
            _context = context;
        }

        // GET: Cvs
        public async Task<IActionResult> Index()
        {
            return View(await _context.Cv.ToListAsync());
        }




    }
}
