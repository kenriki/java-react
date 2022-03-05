import React from 'react';
import Title from './views/header';
import MenuContent1 from './views/content1';

import '../css/styleMain.css';

//classNameでcssを指定
class MenuApp extends React.Component {
    render() {
        return (
            <>
                <Title />
                <MenuContent1 />
            </>
        );
    }
}

//module.exports = App;
export default MenuApp;