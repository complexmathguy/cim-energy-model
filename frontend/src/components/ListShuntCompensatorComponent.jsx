import React, { Component } from 'react'
import ShuntCompensatorService from '../services/ShuntCompensatorService'

class ListShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                shuntCompensators: []
        }
        this.addShuntCompensator = this.addShuntCompensator.bind(this);
        this.editShuntCompensator = this.editShuntCompensator.bind(this);
        this.deleteShuntCompensator = this.deleteShuntCompensator.bind(this);
    }

    deleteShuntCompensator(id){
        ShuntCompensatorService.deleteShuntCompensator(id).then( res => {
            this.setState({shuntCompensators: this.state.shuntCompensators.filter(shuntCompensator => shuntCompensator.shuntCompensatorId !== id)});
        });
    }
    viewShuntCompensator(id){
        this.props.history.push(`/view-shuntCompensator/${id}`);
    }
    editShuntCompensator(id){
        this.props.history.push(`/add-shuntCompensator/${id}`);
    }

    componentDidMount(){
        ShuntCompensatorService.getShuntCompensators().then((res) => {
            this.setState({ shuntCompensators: res.data});
        });
    }

    addShuntCompensator(){
        this.props.history.push('/add-shuntCompensator/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ShuntCompensator List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addShuntCompensator}> Add ShuntCompensator</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> AVRDelay </th>
                                    <th> Grounded </th>
                                    <th> MaximumSections </th>
                                    <th> NomU </th>
                                    <th> NormalSections </th>
                                    <th> SwitchOnCount </th>
                                    <th> SwitchOnDate </th>
                                    <th> VoltageSensitivity </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.shuntCompensators.map(
                                        shuntCompensator => 
                                        <tr key = {shuntCompensator.shuntCompensatorId}>
                                             <td> { shuntCompensator.aVRDelay } </td>
                                             <td> { shuntCompensator.grounded } </td>
                                             <td> { shuntCompensator.maximumSections } </td>
                                             <td> { shuntCompensator.nomU } </td>
                                             <td> { shuntCompensator.normalSections } </td>
                                             <td> { shuntCompensator.switchOnCount } </td>
                                             <td> { shuntCompensator.switchOnDate } </td>
                                             <td> { shuntCompensator.voltageSensitivity } </td>
                                             <td>
                                                 <button onClick={ () => this.editShuntCompensator(shuntCompensator.shuntCompensatorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteShuntCompensator(shuntCompensator.shuntCompensatorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewShuntCompensator(shuntCompensator.shuntCompensatorId)} className="btn btn-info btn-sm">View </button>
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

export default ListShuntCompensatorComponent
