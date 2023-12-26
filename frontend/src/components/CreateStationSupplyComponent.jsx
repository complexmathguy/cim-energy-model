import React, { Component } from 'react'
import StationSupplyService from '../services/StationSupplyService';

class CreateStationSupplyComponent extends Component {
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
            StationSupplyService.getStationSupplyById(this.state.id).then( (res) =>{
                let stationSupply = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateStationSupply = (e) => {
        e.preventDefault();
        let stationSupply = {
                stationSupplyId: this.state.id,
            };
        console.log('stationSupply => ' + JSON.stringify(stationSupply));

        // step 5
        if(this.state.id === '_add'){
            stationSupply.stationSupplyId=''
            StationSupplyService.createStationSupply(stationSupply).then(res =>{
                this.props.history.push('/stationSupplys');
            });
        }else{
            StationSupplyService.updateStationSupply(stationSupply).then( res => {
                this.props.history.push('/stationSupplys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/stationSupplys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add StationSupply</h3>
        }else{
            return <h3 className="text-center">Update StationSupply</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateStationSupply}>Save</button>
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

export default CreateStationSupplyComponent
