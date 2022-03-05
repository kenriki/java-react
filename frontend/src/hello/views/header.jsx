var React = require('react');

//ヘッダの定義
class Header extends React.Component {
  render() {
    return (
      <>
        <header>
          <a href="./"><h2>My Engineer Exhibition Wiki</h2></a>
          <hr />
        </header>
      </>
    );
  }
}

//module.exports = Header;
export default Header;