import React, { Component } from 'react'
import BusNameMarkerService from '../services/BusNameMarkerService';

class CreateBusNameMarkerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                priority: ''
        }
        this.changepriorityHandler = this.changepriorityHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            BusNameMarkerService.getBusNameMarkerById(this.state.id).then( (res) =>{
                let busNameMarker = res.data;
                this.setState({
                    priority: busNameMarker.priority
                });
            });
        }        
    }
    saveOrUpdateBusNameMarker = (e) => {
        e.preventDefault();
        let busNameMarker = {
                busNameMarkerId: this.state.id,
                priority: this.state.priority
            };
        console.log('busNameMarker => ' + JSON.stringify(busNameMarker));

        // step 5
        if(this.state.id === '_add'){
            busNameMarker.busNameMarkerId=''
            BusNameMarkerService.createBusNameMarker(busNameMarker).then(res =>{
                this.props.history.push('/busNameMarkers');
            });
        }else{
            BusNameMarkerService.updateBusNameMarker(busNameMarker).then( res => {
                this.props.history.push('/busNameMarkers');
            });
        }
    }
    
    changepriorityHandler= (event) => {
        this.setState({priority: event.target.value});
    }

    cancel(){
        this.props.history.push('/busNameMarkers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add BusNameMarker</h3>
        }else{
            return <h3 className="text-center">Update BusNameMarker</h3>
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
                                            <label> priority: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBusNameMarker}>Save</button>
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

export default CreateBusNameMarkerComponent
