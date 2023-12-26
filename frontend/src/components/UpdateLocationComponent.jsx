import React, { Component } from 'react'
import LocationService from '../services/LocationService';

class UpdateLocationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLocation = this.updateLocation.bind(this);

    }

    componentDidMount(){
        LocationService.getLocationById(this.state.id).then( (res) =>{
            let location = res.data;
            this.setState({
            });
        });
    }

    updateLocation = (e) => {
        e.preventDefault();
        let location = {
            locationId: this.state.id,
        };
        console.log('location => ' + JSON.stringify(location));
        console.log('id => ' + JSON.stringify(this.state.id));
        LocationService.updateLocation(location).then( res => {
            this.props.history.push('/locations');
        });
    }


    cancel(){
        this.props.history.push('/locations');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Location</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLocation}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateLocationComponent
