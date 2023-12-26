import React, { Component } from 'react'
import ConductorService from '../services/ConductorService'

class ListConductorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                conductors: []
        }
        this.addConductor = this.addConductor.bind(this);
        this.editConductor = this.editConductor.bind(this);
        this.deleteConductor = this.deleteConductor.bind(this);
    }

    deleteConductor(id){
        ConductorService.deleteConductor(id).then( res => {
            this.setState({conductors: this.state.conductors.filter(conductor => conductor.conductorId !== id)});
        });
    }
    viewConductor(id){
        this.props.history.push(`/view-conductor/${id}`);
    }
    editConductor(id){
        this.props.history.push(`/add-conductor/${id}`);
    }

    componentDidMount(){
        ConductorService.getConductors().then((res) => {
            this.setState({ conductors: res.data});
        });
    }

    addConductor(){
        this.props.history.push('/add-conductor/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Conductor List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConductor}> Add Conductor</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Length </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.conductors.map(
                                        conductor => 
                                        <tr key = {conductor.conductorId}>
                                             <td> { conductor.length } </td>
                                             <td>
                                                 <button onClick={ () => this.editConductor(conductor.conductorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConductor(conductor.conductorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConductor(conductor.conductorId)} className="btn btn-info btn-sm">View </button>
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

export default ListConductorComponent
