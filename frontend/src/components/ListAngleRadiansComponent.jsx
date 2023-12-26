import React, { Component } from 'react'
import AngleRadiansService from '../services/AngleRadiansService'

class ListAngleRadiansComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                angleRadianss: []
        }
        this.addAngleRadians = this.addAngleRadians.bind(this);
        this.editAngleRadians = this.editAngleRadians.bind(this);
        this.deleteAngleRadians = this.deleteAngleRadians.bind(this);
    }

    deleteAngleRadians(id){
        AngleRadiansService.deleteAngleRadians(id).then( res => {
            this.setState({angleRadianss: this.state.angleRadianss.filter(angleRadians => angleRadians.angleRadiansId !== id)});
        });
    }
    viewAngleRadians(id){
        this.props.history.push(`/view-angleRadians/${id}`);
    }
    editAngleRadians(id){
        this.props.history.push(`/add-angleRadians/${id}`);
    }

    componentDidMount(){
        AngleRadiansService.getAngleRadianss().then((res) => {
            this.setState({ angleRadianss: res.data});
        });
    }

    addAngleRadians(){
        this.props.history.push('/add-angleRadians/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AngleRadians List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAngleRadians}> Add AngleRadians</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.angleRadianss.map(
                                        angleRadians => 
                                        <tr key = {angleRadians.angleRadiansId}>
                                             <td> { angleRadians.multiplier } </td>
                                             <td> { angleRadians.unit } </td>
                                             <td> { angleRadians.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editAngleRadians(angleRadians.angleRadiansId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAngleRadians(angleRadians.angleRadiansId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAngleRadians(angleRadians.angleRadiansId)} className="btn btn-info btn-sm">View </button>
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

export default ListAngleRadiansComponent
