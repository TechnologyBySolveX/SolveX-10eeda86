
function App() {
  return (
    <div className="App">
        <h2>This is the Example of React Applications .</h2>
    </div>
  );
}

// Named export component
export function Hi() {
  return <h2>This is the Example of the Hi function.</h2>;
}

// Another named export component
export function Footer() {
  return <footer><p>© 2026 My React App</p></footer>;
}

export function Hello(){
  return <h3>this is the Example of the hello ...</h3>
}

export default App;
