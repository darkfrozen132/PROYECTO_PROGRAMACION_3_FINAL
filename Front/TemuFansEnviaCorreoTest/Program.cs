using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansEnviaCorreos;

namespace TemuFansEnviaCorreoTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            EnviaCorreo objLogic = new EnviaCorreo();
            string body = @"<style>
                            h1{color:dodgerblue;}
                            h2{color:darkorange;}
                            </style>
                            <h1>Este es un test</h1></br>
                            <h2>Hola</h2>";
            objLogic.sendMail("", "Alerta de stock", body);
        }
    }
}
