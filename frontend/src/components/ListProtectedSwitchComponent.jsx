import React, { Component } from 'react'
import ProtectedSwitchService from '../services/ProtectedSwitchService'

class ListProtectedSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                protectedSwitchs: []
        }
        this.addProtectedSwitch = this.addProtectedSwitch.bind(this);
        this.editProtectedSwitch = this.editProtectedSwitch.bind(this);
        this.deleteProtectedSwitch = this.deleteProtectedSwitch.bind(this);
    }

    deleteProtectedSwitch(id){
        ProtectedSwitchService.deleteProtectedSwitch(id).then( res => {
            this.setState({protectedSwitchs: this.state.protectedSwitchs.filter(protectedSwitch => protectedSwitch.protectedSwitchId !== id)});
        });
    }
    viewProtectedSwitch(id){
        this.props.history.push(`/view-protectedSwitch/${id}`);
    }
    editProtectedSwitch(id){
        this.props.history.push(`/add-protectedSwitch/${id}`);
    }

    componentDidMount(){
        ProtectedSwitchService.getProtectedSwitchs().then((res) => {
            this.setState({ protectedSwitchs: res.data});
        });
    }

    addProtectedSwitch(){
        this.props.history.push('/add-protectedSwitch/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ProtectedSwitch List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addProtectedSwitch}> Add ProtectedSwitch</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.protectedSwitchs.map(
                                        protectedSwitch => 
                                        <tr key = {protectedSwitch.protectedSwitchId}>
                                             <td>
                                                 <button onClick={ () => this.editProtectedSwitch(protectedSwitch.protectedSwitchId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteProtectedSwitch(protectedSwitch.protectedSwitchId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewProtectedSwitch(protectedSwitch.protectedSwitchId)} className="btn btn-info btn-sm">View </button>
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

export default ListProtectedSwitchComponent
