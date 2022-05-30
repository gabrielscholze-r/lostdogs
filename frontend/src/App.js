import { useEffect, useState } from 'react';
import './App.css';
import API from './config/API';

function App() {
  const [list, setList] = useState([])
  async function geter(){
    var content = await API.get('/person')
    setList(content.data)
  }
  useEffect(() => {geter(); console.log(list)},[])

  return (
    <div className="App">
      Test
    </div>
  );
}

export default App;
