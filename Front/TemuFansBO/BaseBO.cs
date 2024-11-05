using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO.ServicioWS;

namespace TemuFansBO
{
    public class BaseBO
    {
        private ServicioWS.ServicioWSClient servicioWS;

        public BaseBO()
        {
            this.ServicioWS = new ServicioWS.ServicioWSClient();
        }
        public ServicioWSClient ServicioWS
        {
            get => servicioWS; set => servicioWS = value;
        }

        
    }
    
}
