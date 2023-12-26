import React, { Component } from 'react'
import ControlService from '../services/ControlService'

class ListControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                controls: []
        }
        this.addControl = this.addControl.bind(this);
        this.editControl = this.editControl.bind(this);
        this.deleteControl = this.deleteControl.bind(this);
    }

    deleteControl(id){
        ControlService.deleteControl(id).then( res => {
            this.setState({controls: this.state.controls.filter(control => control.controlId !== id)});
        });
    }
    viewControl(id){
        this.props.history.push(`/view-control/${id}`);
    }
    editControl(id){
        this.props.history.push(`/add-control/${id}`);
    }

    componentDidMount(){
        ControlService.getControls().then((res) => {
            this.setState({ controls: res.data});
        });
    }

    addControl(){
        this.props.history.push('/add-control/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Control List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addControl}> Add Control</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> ControlType </th>
                                    <th> OperationInProgress </th>
                                    <th> TimeStamp </th>
                                    <th> UnitMultiplier </th>
                                    <th> UnitSymbol </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.controls.map(
                                        control => 
                                        <tr key = {control.controlId}>
                                             <td> { control.controlType } </td>
                                             <td> { control.operationInProgress } </td>
                                             <td> { control.timeStamp } </td>
                                             <td> { control.unitMultiplier } </td>
                                             <td> { control.unitSymbol } </td>
                                             <td>
                                                 <button onClick={ () => this.editControl(control.controlId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteControl(control.controlId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewControl(control.controlId)} className="btn btn-info btn-sm">View </button>
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

export default ListControlComponent
