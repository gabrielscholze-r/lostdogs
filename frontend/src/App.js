import { useContext, useEffect, useState } from 'react';
import { Cookies, CookiesProvider, useCookies } from 'react-cookie';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import API from './config/API';
import Homepage from './pages/Homepage';
import Rotas from './config/routes'
import AuthContext from './config/auth';
function App() {
  const [cookies, setCookies] = useCookies(['auth'])
  const [isLogged, setLogged] = useState(false)
  return (
    <div className="App">
      <BrowserRouter>
        <CookiesProvider>
          <AuthContext.Provider value={[isLogged, setLogged]}>
            <Rotas />
          </AuthContext.Provider>
        </CookiesProvider>
      </BrowserRouter>
    </div>
  );
}

export default App;
