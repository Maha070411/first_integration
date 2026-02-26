function Signup() {
  return (
    <div>
      <h2>Signup</h2>
      <form>
        <input type="text" placeholder="Enter full name" /><br />
        <input type="email" placeholder="Enter email" /><br />
        <input type="password" placeholder="Enter password" /><br />
        <input type="password" placeholder="Confirm password" /><br />
        <button type="submit">Signup</button>
      </form>
    </div>
  );
}

export default Signup;