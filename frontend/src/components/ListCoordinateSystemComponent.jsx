import React, { Component } from 'react'
import CoordinateSystemService from '../services/CoordinateSystemService'

class ListCoordinateSystemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                coordinateSystems: []
        }
        this.addCoordinateSystem = this.addCoordinateSystem.bind(this);
        this.editCoordinateSystem = this.editCoordinateSystem.bind(this);
        this.deleteCoordinateSystem = this.deleteCoordinateSystem.bind(this);
    }

    deleteCoordinateSystem(id){
        CoordinateSystemService.deleteCoordinateSystem(id).then( res => {
            this.setState({coordinateSystems: this.state.coordinateSystems.filter(coordinateSystem => coordinateSystem.coordinateSystemId !== id)});
        });
    }
    viewCoordinateSystem(id){
        this.props.history.push(`/view-coordinateSystem/${id}`);
    }
    editCoordinateSystem(id){
        this.props.history.push(`/add-coordinateSystem/${id}`);
    }

    componentDidMount(){
        CoordinateSystemService.getCoordinateSystems().then((res) => {
            this.setState({ coordinateSystems: res.data});
        });
    }

    addCoordinateSystem(){
        this.props.history.push('/add-coordinateSystem/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">CoordinateSystem List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCoordinateSystem}> Add CoordinateSystem</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> CrsUrn </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.coordinateSystems.map(
                                        coordinateSystem => 
                                        <tr key = {coordinateSystem.coordinateSystemId}>
                                             <td> { coordinateSystem.crsUrn } </td>
                                             <td>
                                                 <button onClick={ () => this.editCoordinateSystem(coordinateSystem.coordinateSystemId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCoordinateSystem(coordinateSystem.coordinateSystemId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCoordinateSystem(coordinateSystem.coordinateSystemId)} className="btn btn-info btn-sm">View </button>
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

export default ListCoordinateSystemComponent
