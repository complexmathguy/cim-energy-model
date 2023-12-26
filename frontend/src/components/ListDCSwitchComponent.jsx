import React, { Component } from 'react'
import DCSwitchService from '../services/DCSwitchService'

class ListDCSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCSwitchs: []
        }
        this.addDCSwitch = this.addDCSwitch.bind(this);
        this.editDCSwitch = this.editDCSwitch.bind(this);
        this.deleteDCSwitch = this.deleteDCSwitch.bind(this);
    }

    deleteDCSwitch(id){
        DCSwitchService.deleteDCSwitch(id).then( res => {
            this.setState({dCSwitchs: this.state.dCSwitchs.filter(dCSwitch => dCSwitch.dCSwitchId !== id)});
        });
    }
    viewDCSwitch(id){
        this.props.history.push(`/view-dCSwitch/${id}`);
    }
    editDCSwitch(id){
        this.props.history.push(`/add-dCSwitch/${id}`);
    }

    componentDidMount(){
        DCSwitchService.getDCSwitchs().then((res) => {
            this.setState({ dCSwitchs: res.data});
        });
    }

    addDCSwitch(){
        this.props.history.push('/add-dCSwitch/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCSwitch List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCSwitch}> Add DCSwitch</button>
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
                                    this.state.dCSwitchs.map(
                                        dCSwitch => 
                                        <tr key = {dCSwitch.dCSwitchId}>
                                             <td>
                                                 <button onClick={ () => this.editDCSwitch(dCSwitch.dCSwitchId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCSwitch(dCSwitch.dCSwitchId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCSwitch(dCSwitch.dCSwitchId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCSwitchComponent
