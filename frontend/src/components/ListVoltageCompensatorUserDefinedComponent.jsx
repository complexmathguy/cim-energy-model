import React, { Component } from 'react'
import VoltageCompensatorUserDefinedService from '../services/VoltageCompensatorUserDefinedService'

class ListVoltageCompensatorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltageCompensatorUserDefineds: []
        }
        this.addVoltageCompensatorUserDefined = this.addVoltageCompensatorUserDefined.bind(this);
        this.editVoltageCompensatorUserDefined = this.editVoltageCompensatorUserDefined.bind(this);
        this.deleteVoltageCompensatorUserDefined = this.deleteVoltageCompensatorUserDefined.bind(this);
    }

    deleteVoltageCompensatorUserDefined(id){
        VoltageCompensatorUserDefinedService.deleteVoltageCompensatorUserDefined(id).then( res => {
            this.setState({voltageCompensatorUserDefineds: this.state.voltageCompensatorUserDefineds.filter(voltageCompensatorUserDefined => voltageCompensatorUserDefined.voltageCompensatorUserDefinedId !== id)});
        });
    }
    viewVoltageCompensatorUserDefined(id){
        this.props.history.push(`/view-voltageCompensatorUserDefined/${id}`);
    }
    editVoltageCompensatorUserDefined(id){
        this.props.history.push(`/add-voltageCompensatorUserDefined/${id}`);
    }

    componentDidMount(){
        VoltageCompensatorUserDefinedService.getVoltageCompensatorUserDefineds().then((res) => {
            this.setState({ voltageCompensatorUserDefineds: res.data});
        });
    }

    addVoltageCompensatorUserDefined(){
        this.props.history.push('/add-voltageCompensatorUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VoltageCompensatorUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltageCompensatorUserDefined}> Add VoltageCompensatorUserDefined</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Proprietary </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.voltageCompensatorUserDefineds.map(
                                        voltageCompensatorUserDefined => 
                                        <tr key = {voltageCompensatorUserDefined.voltageCompensatorUserDefinedId}>
                                             <td> { voltageCompensatorUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editVoltageCompensatorUserDefined(voltageCompensatorUserDefined.voltageCompensatorUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltageCompensatorUserDefined(voltageCompensatorUserDefined.voltageCompensatorUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltageCompensatorUserDefined(voltageCompensatorUserDefined.voltageCompensatorUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltageCompensatorUserDefinedComponent
