import React, { Component } from 'react'
import SvVoltageService from '../services/SvVoltageService'

class ListSvVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                svVoltages: []
        }
        this.addSvVoltage = this.addSvVoltage.bind(this);
        this.editSvVoltage = this.editSvVoltage.bind(this);
        this.deleteSvVoltage = this.deleteSvVoltage.bind(this);
    }

    deleteSvVoltage(id){
        SvVoltageService.deleteSvVoltage(id).then( res => {
            this.setState({svVoltages: this.state.svVoltages.filter(svVoltage => svVoltage.svVoltageId !== id)});
        });
    }
    viewSvVoltage(id){
        this.props.history.push(`/view-svVoltage/${id}`);
    }
    editSvVoltage(id){
        this.props.history.push(`/add-svVoltage/${id}`);
    }

    componentDidMount(){
        SvVoltageService.getSvVoltages().then((res) => {
            this.setState({ svVoltages: res.data});
        });
    }

    addSvVoltage(){
        this.props.history.push('/add-svVoltage/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SvVoltage List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSvVoltage}> Add SvVoltage</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Angle </th>
                                    <th> V </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.svVoltages.map(
                                        svVoltage => 
                                        <tr key = {svVoltage.svVoltageId}>
                                             <td> { svVoltage.angle } </td>
                                             <td> { svVoltage.v } </td>
                                             <td>
                                                 <button onClick={ () => this.editSvVoltage(svVoltage.svVoltageId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSvVoltage(svVoltage.svVoltageId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSvVoltage(svVoltage.svVoltageId)} className="btn btn-info btn-sm">View </button>
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

export default ListSvVoltageComponent
