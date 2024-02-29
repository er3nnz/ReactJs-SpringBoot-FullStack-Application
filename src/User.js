import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import { Button, Paper } from '@mui/material';

export default function User() {
  const paperStyle = { padding: '50px 20px', width: 600, margin: '150px auto' }
  const [name, setName] = React.useState('')
  const [password, setPassword] = React.useState('')
  const handleClick = (e) => {
    e.preventDefault()
    const user = { name, password }
    console.log(user)
    fetch("http://localhost:8080/user/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(user)
    }).then(() => {
    })
  }
  return (

    <Container>
      <Paper elevation={3} style={{ ...paperStyle, backgroundColor: 'darkgray', boxShadow: '0px 4px 8px rgba(0, 0, 0,2, 0.2)',borderRadius: '10px' }}>
        <h1 style={{ color: "black" }}>Welcome Back ! </h1>
        <Box
          component="form"
          sx={{
            '& > :not(style)': { m: 1 },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField id="outlined-basic" label="UserName" variant="outlined" fullWidth
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <TextField id="outlined-basic" label="Password" variant="outlined" fullWidth type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </Box>
        <Button variant='contained' style={{backgroundColor: 'gray', color: 'black'}} onClick={handleClick}>Login</Button>
      </Paper>
    </Container>
  );
}
