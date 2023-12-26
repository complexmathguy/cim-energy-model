import React, { Component } from 'react'
import LocationService from '../services/LocationService';

class CreateLocationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            LocationService.getLocationById(this.state.id).then( (res) =>{
                let location = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLocation = (e) => {
        e.preventDefault();
        let location = {
                locationId: this.state.id,
            };
        console.log('location => ' + JSON.stringify(location));

        // step 5
        if(this.state.id === '_add'){
            location.locationId=''
            LocationService.createLocation(location).then(res =>{
                this.props.history.push('/locations');
            });
        }else{
            LocationService.updateLocation(location).then( res => {
                this.props.history.push('/locations');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/locations');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Location</h3>
        }else{
            return <h3 className="text-center">Update Location</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLocation}>Save</button>
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

export default CreateLocationComponent
