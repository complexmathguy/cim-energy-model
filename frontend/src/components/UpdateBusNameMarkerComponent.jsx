import React, { Component } from 'react'
import BusNameMarkerService from '../services/BusNameMarkerService';

class UpdateBusNameMarkerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                priority: ''
        }
        this.updateBusNameMarker = this.updateBusNameMarker.bind(this);

        this.changepriorityHandler = this.changepriorityHandler.bind(this);
    }

    componentDidMount(){
        BusNameMarkerService.getBusNameMarkerById(this.state.id).then( (res) =>{
            let busNameMarker = res.data;
            this.setState({
                priority: busNameMarker.priority
            });
        });
    }

    updateBusNameMarker = (e) => {
        e.preventDefault();
        let busNameMarker = {
            busNameMarkerId: this.state.id,
            priority: this.state.priority
        };
        console.log('busNameMarker => ' + JSON.stringify(busNameMarker));
        console.log('id => ' + JSON.stringify(this.state.id));
        BusNameMarkerService.updateBusNameMarker(busNameMarker).then( res => {
            this.props.history.push('/busNameMarkers');
        });
    }

    changepriorityHandler= (event) => {
        this.setState({priority: event.target.value});
    }

    cancel(){
        this.props.history.push('/busNameMarkers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update BusNameMarker</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> priority: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBusNameMarker}>Save</button>
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

export default UpdateBusNameMarkerComponent
