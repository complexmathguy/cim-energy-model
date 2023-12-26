import React, { Component } from 'react'
import RegulatingControlService from '../services/RegulatingControlService'

class ListRegulatingControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                regulatingControls: []
        }
        this.addRegulatingControl = this.addRegulatingControl.bind(this);
        this.editRegulatingControl = this.editRegulatingControl.bind(this);
        this.deleteRegulatingControl = this.deleteRegulatingControl.bind(this);
    }

    deleteRegulatingControl(id){
        RegulatingControlService.deleteRegulatingControl(id).then( res => {
            this.setState({regulatingControls: this.state.regulatingControls.filter(regulatingControl => regulatingControl.regulatingControlId !== id)});
        });
    }
    viewRegulatingControl(id){
        this.props.history.push(`/view-regulatingControl/${id}`);
    }
    editRegulatingControl(id){
        this.props.history.push(`/add-regulatingControl/${id}`);
    }

    componentDidMount(){
        RegulatingControlService.getRegulatingControls().then((res) => {
            this.setState({ regulatingControls: res.data});
        });
    }

    addRegulatingControl(){
        this.props.history.push('/add-regulatingControl/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RegulatingControl List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRegulatingControl}> Add RegulatingControl</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Mode </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.regulatingControls.map(
                                        regulatingControl => 
                                        <tr key = {regulatingControl.regulatingControlId}>
                                             <td> { regulatingControl.mode } </td>
                                             <td>
                                                 <button onClick={ () => this.editRegulatingControl(regulatingControl.regulatingControlId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRegulatingControl(regulatingControl.regulatingControlId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRegulatingControl(regulatingControl.regulatingControlId)} className="btn btn-info btn-sm">View </button>
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

export default ListRegulatingControlComponent
