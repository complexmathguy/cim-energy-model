import React, { Component } from 'react'
import AngleDegreesService from '../services/AngleDegreesService'

class ListAngleDegreesComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                angleDegreess: []
        }
        this.addAngleDegrees = this.addAngleDegrees.bind(this);
        this.editAngleDegrees = this.editAngleDegrees.bind(this);
        this.deleteAngleDegrees = this.deleteAngleDegrees.bind(this);
    }

    deleteAngleDegrees(id){
        AngleDegreesService.deleteAngleDegrees(id).then( res => {
            this.setState({angleDegreess: this.state.angleDegreess.filter(angleDegrees => angleDegrees.angleDegreesId !== id)});
        });
    }
    viewAngleDegrees(id){
        this.props.history.push(`/view-angleDegrees/${id}`);
    }
    editAngleDegrees(id){
        this.props.history.push(`/add-angleDegrees/${id}`);
    }

    componentDidMount(){
        AngleDegreesService.getAngleDegreess().then((res) => {
            this.setState({ angleDegreess: res.data});
        });
    }

    addAngleDegrees(){
        this.props.history.push('/add-angleDegrees/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AngleDegrees List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAngleDegrees}> Add AngleDegrees</button>
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
                                    this.state.angleDegreess.map(
                                        angleDegrees => 
                                        <tr key = {angleDegrees.angleDegreesId}>
                                             <td> { angleDegrees.multiplier } </td>
                                             <td> { angleDegrees.unit } </td>
                                             <td> { angleDegrees.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editAngleDegrees(angleDegrees.angleDegreesId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAngleDegrees(angleDegrees.angleDegreesId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAngleDegrees(angleDegrees.angleDegreesId)} className="btn btn-info btn-sm">View </button>
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

export default ListAngleDegreesComponent
