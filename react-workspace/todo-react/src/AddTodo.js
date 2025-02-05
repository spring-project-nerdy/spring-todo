import React, { useState } from "react";

import { Button, TextField } from "@mui/material";
import Grid from '@mui/material/Grid2';

const AddTodo = (props) => {
    // 사용자의 입력을 지정할 오브젝트
    const [ item, setItem ] = useState({title: ""});
    const addItem = props.addItem;

    // onButtonClick 함수 작성
    const onButtonClick = () => {
        addItem(item); // addItem 함수 사용
        setItem({title: ""});
    }

    // onInputChange 함수 작성
    const onInputChange = (e) => {
        setItem({title: e.target.value});
        console.log(item);
    }

    // enterkeyEventHandler 함수
    const enterkeyEventHandler = (e) => {
        if (e.key === 'Enter') {
            onButtonClick();
        }
    }

    // onInputChange 함수 TextField에 연결
    return (
        <Grid container style={{marginTop: 20}}>
            <Grid size={{xs: 11, md: 11}} item style={{paddingRight: 16}}>
                <TextField placeholder="Add Todo here" fullWidth  onChange={onInputChange}  onKeyDown={enterkeyEventHandler} value={item.title}/>
            </Grid>
            <Grid size={{xs: 1, md: 1}} item>
                <Button fullWidth sytle={{height: '100%'}} color="secondary" variant="outlined" onClick={onButtonClick}> + </Button>
            </Grid>
        </Grid>
    );
}

export default AddTodo;