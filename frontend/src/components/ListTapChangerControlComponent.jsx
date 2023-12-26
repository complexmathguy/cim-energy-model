import React, { Component } from 'react'
import TapChangerControlService from '../services/TapChangerControlService'

class ListTapChangerControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                tapChangerControls: []
        }
        this.addTapChangerControl = this.addTapChangerControl.bind(this);
        this.editTapChangerControl = this.editTapChangerControl.bind(this);
        this.deleteTapChangerControl = this.deleteTapChangerControl.bind(this);
    }

    deleteTapChangerControl(id){
        TapChangerControlService.deleteTapChangerControl(id).then( res => {
            this.setState({tapChangerControls: this.state.tapChangerControls.filter(tapChangerControl => tapChangerControl.tapChangerControlId !== id)});
        });
    }
    viewTapChangerControl(id){
        this.props.history.push(`/view-tapChangerControl/${id}`);
    }
    editTapChangerControl(id){
        this.props.history.push(`/add-tapChangerControl/${id}`);
    }

    componentDidMount(){
        TapChangerControlService.getTapChangerControls().then((res) => {
            this.setState({ tapChangerControls: res.data});
        });
    }

    addTapChangerControl(){
        this.props.history.push('/add-tapChangerControl/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TapChangerControl List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTapChangerControl}> Add TapChangerControl</button>
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
                                    this.state.tapChangerControls.map(
                                        tapChangerControl => 
                                        <tr key = {tapChangerControl.tapChangerControlId}>
                                             <td>
                                                 <button onClick={ () => this.editTapChangerControl(tapChangerControl.tapChangerControlId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTapChangerControl(tapChangerControl.tapChangerControlId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTapChangerControl(tapChangerControl.tapChangerControlId)} className="btn btn-info btn-sm">View </button>
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

export default ListTapChangerControlComponent
