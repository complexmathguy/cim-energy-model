import React, { Component } from 'react'
import SwitchItService from '../services/SwitchItService'

class ListSwitchItComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                switchIts: []
        }
        this.addSwitchIt = this.addSwitchIt.bind(this);
        this.editSwitchIt = this.editSwitchIt.bind(this);
        this.deleteSwitchIt = this.deleteSwitchIt.bind(this);
    }

    deleteSwitchIt(id){
        SwitchItService.deleteSwitchIt(id).then( res => {
            this.setState({switchIts: this.state.switchIts.filter(switchIt => switchIt.switchItId !== id)});
        });
    }
    viewSwitchIt(id){
        this.props.history.push(`/view-switchIt/${id}`);
    }
    editSwitchIt(id){
        this.props.history.push(`/add-switchIt/${id}`);
    }

    componentDidMount(){
        SwitchItService.getSwitchIts().then((res) => {
            this.setState({ switchIts: res.data});
        });
    }

    addSwitchIt(){
        this.props.history.push('/add-switchIt/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SwitchIt List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSwitchIt}> Add SwitchIt</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Open </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.switchIts.map(
                                        switchIt => 
                                        <tr key = {switchIt.switchItId}>
                                             <td> { switchIt.open } </td>
                                             <td>
                                                 <button onClick={ () => this.editSwitchIt(switchIt.switchItId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSwitchIt(switchIt.switchItId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSwitchIt(switchIt.switchItId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListSwitchItComponent
