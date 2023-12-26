import React, { Component } from 'react'
import StationSupplyService from '../services/StationSupplyService';

class UpdateStationSupplyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateStationSupply = this.updateStationSupply.bind(this);

    }

    componentDidMount(){
        StationSupplyService.getStationSupplyById(this.state.id).then( (res) =>{
            let stationSupply = res.data;
            this.setState({
            });
        });
    }

    updateStationSupply = (e) => {
        e.preventDefault();
        let stationSupply = {
            stationSupplyId: this.state.id,
        };
        console.log('stationSupply => ' + JSON.stringify(stationSupply));
        console.log('id => ' + JSON.stringify(this.state.id));
        StationSupplyService.updateStationSupply(stationSupply).then( res => {
            this.props.history.push('/stationSupplys');
        });
    }


    cancel(){
        this.props.history.push('/stationSupplys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update StationSupply</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStationSupply}>Save</button>
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

export default UpdateStationSupplyComponent
