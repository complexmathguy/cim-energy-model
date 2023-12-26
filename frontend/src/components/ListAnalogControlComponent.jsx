import React, { Component } from 'react'
import AnalogControlService from '../services/AnalogControlService'

class ListAnalogControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                analogControls: []
        }
        this.addAnalogControl = this.addAnalogControl.bind(this);
        this.editAnalogControl = this.editAnalogControl.bind(this);
        this.deleteAnalogControl = this.deleteAnalogControl.bind(this);
    }

    deleteAnalogControl(id){
        AnalogControlService.deleteAnalogControl(id).then( res => {
            this.setState({analogControls: this.state.analogControls.filter(analogControl => analogControl.analogControlId !== id)});
        });
    }
    viewAnalogControl(id){
        this.props.history.push(`/view-analogControl/${id}`);
    }
    editAnalogControl(id){
        this.props.history.push(`/add-analogControl/${id}`);
    }

    componentDidMount(){
        AnalogControlService.getAnalogControls().then((res) => {
            this.setState({ analogControls: res.data});
        });
    }

    addAnalogControl(){
        this.props.history.push('/add-analogControl/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AnalogControl List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAnalogControl}> Add AnalogControl</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> MaxValue </th>
                                    <th> MinValue </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.analogControls.map(
                                        analogControl => 
                                        <tr key = {analogControl.analogControlId}>
                                             <td> { analogControl.maxValue } </td>
                                             <td> { analogControl.minValue } </td>
                                             <td>
                                                 <button onClick={ () => this.editAnalogControl(analogControl.analogControlId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAnalogControl(analogControl.analogControlId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnalogControl(analogControl.analogControlId)} className="btn btn-info btn-sm">View </button>
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

export default ListAnalogControlComponent
