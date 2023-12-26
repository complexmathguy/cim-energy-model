import React, { Component } from 'react'
import LocationService from '../services/LocationService'

class ListLocationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                locations: []
        }
        this.addLocation = this.addLocation.bind(this);
        this.editLocation = this.editLocation.bind(this);
        this.deleteLocation = this.deleteLocation.bind(this);
    }

    deleteLocation(id){
        LocationService.deleteLocation(id).then( res => {
            this.setState({locations: this.state.locations.filter(location => location.locationId !== id)});
        });
    }
    viewLocation(id){
        this.props.history.push(`/view-location/${id}`);
    }
    editLocation(id){
        this.props.history.push(`/add-location/${id}`);
    }

    componentDidMount(){
        LocationService.getLocations().then((res) => {
            this.setState({ locations: res.data});
        });
    }

    addLocation(){
        this.props.history.push('/add-location/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Location List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLocation}> Add Location</button>
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
                                    this.state.locations.map(
                                        location => 
                                        <tr key = {location.locationId}>
                                             <td>
                                                 <button onClick={ () => this.editLocation(location.locationId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLocation(location.locationId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLocation(location.locationId)} className="btn btn-info btn-sm">View </button>
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

export default ListLocationComponent
