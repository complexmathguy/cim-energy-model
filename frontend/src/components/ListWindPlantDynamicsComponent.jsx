import React, { Component } from 'react'
import WindPlantDynamicsService from '../services/WindPlantDynamicsService'

class ListWindPlantDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windPlantDynamicss: []
        }
        this.addWindPlantDynamics = this.addWindPlantDynamics.bind(this);
        this.editWindPlantDynamics = this.editWindPlantDynamics.bind(this);
        this.deleteWindPlantDynamics = this.deleteWindPlantDynamics.bind(this);
    }

    deleteWindPlantDynamics(id){
        WindPlantDynamicsService.deleteWindPlantDynamics(id).then( res => {
            this.setState({windPlantDynamicss: this.state.windPlantDynamicss.filter(windPlantDynamics => windPlantDynamics.windPlantDynamicsId !== id)});
        });
    }
    viewWindPlantDynamics(id){
        this.props.history.push(`/view-windPlantDynamics/${id}`);
    }
    editWindPlantDynamics(id){
        this.props.history.push(`/add-windPlantDynamics/${id}`);
    }

    componentDidMount(){
        WindPlantDynamicsService.getWindPlantDynamicss().then((res) => {
            this.setState({ windPlantDynamicss: res.data});
        });
    }

    addWindPlantDynamics(){
        this.props.history.push('/add-windPlantDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindPlantDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindPlantDynamics}> Add WindPlantDynamics</button>
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
                                    this.state.windPlantDynamicss.map(
                                        windPlantDynamics => 
                                        <tr key = {windPlantDynamics.windPlantDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editWindPlantDynamics(windPlantDynamics.windPlantDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindPlantDynamics(windPlantDynamics.windPlantDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindPlantDynamics(windPlantDynamics.windPlantDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindPlantDynamicsComponent
