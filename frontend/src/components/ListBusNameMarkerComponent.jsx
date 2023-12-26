import React, { Component } from 'react'
import BusNameMarkerService from '../services/BusNameMarkerService'

class ListBusNameMarkerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                busNameMarkers: []
        }
        this.addBusNameMarker = this.addBusNameMarker.bind(this);
        this.editBusNameMarker = this.editBusNameMarker.bind(this);
        this.deleteBusNameMarker = this.deleteBusNameMarker.bind(this);
    }

    deleteBusNameMarker(id){
        BusNameMarkerService.deleteBusNameMarker(id).then( res => {
            this.setState({busNameMarkers: this.state.busNameMarkers.filter(busNameMarker => busNameMarker.busNameMarkerId !== id)});
        });
    }
    viewBusNameMarker(id){
        this.props.history.push(`/view-busNameMarker/${id}`);
    }
    editBusNameMarker(id){
        this.props.history.push(`/add-busNameMarker/${id}`);
    }

    componentDidMount(){
        BusNameMarkerService.getBusNameMarkers().then((res) => {
            this.setState({ busNameMarkers: res.data});
        });
    }

    addBusNameMarker(){
        this.props.history.push('/add-busNameMarker/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">BusNameMarker List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBusNameMarker}> Add BusNameMarker</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Priority </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.busNameMarkers.map(
                                        busNameMarker => 
                                        <tr key = {busNameMarker.busNameMarkerId}>
                                             <td> { busNameMarker.priority } </td>
                                             <td>
                                                 <button onClick={ () => this.editBusNameMarker(busNameMarker.busNameMarkerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBusNameMarker(busNameMarker.busNameMarkerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBusNameMarker(busNameMarker.busNameMarkerId)} className="btn btn-info btn-sm">View </button>
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

export default ListBusNameMarkerComponent
