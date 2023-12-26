import React, { Component } from 'react'
import EarthFaultCompensatorService from '../services/EarthFaultCompensatorService'

class ListEarthFaultCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                earthFaultCompensators: []
        }
        this.addEarthFaultCompensator = this.addEarthFaultCompensator.bind(this);
        this.editEarthFaultCompensator = this.editEarthFaultCompensator.bind(this);
        this.deleteEarthFaultCompensator = this.deleteEarthFaultCompensator.bind(this);
    }

    deleteEarthFaultCompensator(id){
        EarthFaultCompensatorService.deleteEarthFaultCompensator(id).then( res => {
            this.setState({earthFaultCompensators: this.state.earthFaultCompensators.filter(earthFaultCompensator => earthFaultCompensator.earthFaultCompensatorId !== id)});
        });
    }
    viewEarthFaultCompensator(id){
        this.props.history.push(`/view-earthFaultCompensator/${id}`);
    }
    editEarthFaultCompensator(id){
        this.props.history.push(`/add-earthFaultCompensator/${id}`);
    }

    componentDidMount(){
        EarthFaultCompensatorService.getEarthFaultCompensators().then((res) => {
            this.setState({ earthFaultCompensators: res.data});
        });
    }

    addEarthFaultCompensator(){
        this.props.history.push('/add-earthFaultCompensator/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EarthFaultCompensator List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEarthFaultCompensator}> Add EarthFaultCompensator</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> R </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.earthFaultCompensators.map(
                                        earthFaultCompensator => 
                                        <tr key = {earthFaultCompensator.earthFaultCompensatorId}>
                                             <td> { earthFaultCompensator.r } </td>
                                             <td>
                                                 <button onClick={ () => this.editEarthFaultCompensator(earthFaultCompensator.earthFaultCompensatorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEarthFaultCompensator(earthFaultCompensator.earthFaultCompensatorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEarthFaultCompensator(earthFaultCompensator.earthFaultCompensatorId)} className="btn btn-info btn-sm">View </button>
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

export default ListEarthFaultCompensatorComponent
