import React, { Component } from 'react'
import VoltageAdjusterUserDefinedService from '../services/VoltageAdjusterUserDefinedService'

class ListVoltageAdjusterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltageAdjusterUserDefineds: []
        }
        this.addVoltageAdjusterUserDefined = this.addVoltageAdjusterUserDefined.bind(this);
        this.editVoltageAdjusterUserDefined = this.editVoltageAdjusterUserDefined.bind(this);
        this.deleteVoltageAdjusterUserDefined = this.deleteVoltageAdjusterUserDefined.bind(this);
    }

    deleteVoltageAdjusterUserDefined(id){
        VoltageAdjusterUserDefinedService.deleteVoltageAdjusterUserDefined(id).then( res => {
            this.setState({voltageAdjusterUserDefineds: this.state.voltageAdjusterUserDefineds.filter(voltageAdjusterUserDefined => voltageAdjusterUserDefined.voltageAdjusterUserDefinedId !== id)});
        });
    }
    viewVoltageAdjusterUserDefined(id){
        this.props.history.push(`/view-voltageAdjusterUserDefined/${id}`);
    }
    editVoltageAdjusterUserDefined(id){
        this.props.history.push(`/add-voltageAdjusterUserDefined/${id}`);
    }

    componentDidMount(){
        VoltageAdjusterUserDefinedService.getVoltageAdjusterUserDefineds().then((res) => {
            this.setState({ voltageAdjusterUserDefineds: res.data});
        });
    }

    addVoltageAdjusterUserDefined(){
        this.props.history.push('/add-voltageAdjusterUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VoltageAdjusterUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltageAdjusterUserDefined}> Add VoltageAdjusterUserDefined</button>
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
                                    this.state.voltageAdjusterUserDefineds.map(
                                        voltageAdjusterUserDefined => 
                                        <tr key = {voltageAdjusterUserDefined.voltageAdjusterUserDefinedId}>
                                             <td> { voltageAdjusterUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editVoltageAdjusterUserDefined(voltageAdjusterUserDefined.voltageAdjusterUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltageAdjusterUserDefined(voltageAdjusterUserDefined.voltageAdjusterUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltageAdjusterUserDefined(voltageAdjusterUserDefined.voltageAdjusterUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltageAdjusterUserDefinedComponent
