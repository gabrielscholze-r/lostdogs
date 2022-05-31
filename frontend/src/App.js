import { useEffect, useState } from 'react';
import { Cookies, CookiesProvider, useCookies } from 'react-cookie';
import { BrowserRouter} from 'react-router-dom';
import './App.css';
import API from './config/API';
import Homepage from './pages/Homepage';
import Rotas from './config/routes'
function App() {
  const [cookies, setCookies] = useCookies(['auth'])
  // useEffect(()=> {setCookies('log', 0,{path: '/'})},[])
  return (
    <div className="App">
      <BrowserRouter>
        <CookiesProvider>
          <Rotas/>
        </CookiesProvider>      
      </BrowserRouter>
    </div>
  );
}

export default App;
