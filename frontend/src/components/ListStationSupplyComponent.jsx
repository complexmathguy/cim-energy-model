import React, { Component } from 'react'
import StationSupplyService from '../services/StationSupplyService'

class ListStationSupplyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                stationSupplys: []
        }
        this.addStationSupply = this.addStationSupply.bind(this);
        this.editStationSupply = this.editStationSupply.bind(this);
        this.deleteStationSupply = this.deleteStationSupply.bind(this);
    }

    deleteStationSupply(id){
        StationSupplyService.deleteStationSupply(id).then( res => {
            this.setState({stationSupplys: this.state.stationSupplys.filter(stationSupply => stationSupply.stationSupplyId !== id)});
        });
    }
    viewStationSupply(id){
        this.props.history.push(`/view-stationSupply/${id}`);
    }
    editStationSupply(id){
        this.props.history.push(`/add-stationSupply/${id}`);
    }

    componentDidMount(){
        StationSupplyService.getStationSupplys().then((res) => {
            this.setState({ stationSupplys: res.data});
        });
    }

    addStationSupply(){
        this.props.history.push('/add-stationSupply/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">StationSupply List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addStationSupply}> Add StationSupply</button>
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
                                    this.state.stationSupplys.map(
                                        stationSupply => 
                                        <tr key = {stationSupply.stationSupplyId}>
                                             <td>
                                                 <button onClick={ () => this.editStationSupply(stationSupply.stationSupplyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStationSupply(stationSupply.stationSupplyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewStationSupply(stationSupply.stationSupplyId)} className="btn btn-info btn-sm">View </button>
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

export default ListStationSupplyComponent
