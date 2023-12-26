import React, { Component } from 'react'
import GeographicalRegionService from '../services/GeographicalRegionService';

class CreateGeographicalRegionComponent extends Component {
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
            GeographicalRegionService.getGeographicalRegionById(this.state.id).then( (res) =>{
                let geographicalRegion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGeographicalRegion = (e) => {
        e.preventDefault();
        let geographicalRegion = {
                geographicalRegionId: this.state.id,
            };
        console.log('geographicalRegion => ' + JSON.stringify(geographicalRegion));

        // step 5
        if(this.state.id === '_add'){
            geographicalRegion.geographicalRegionId=''
            GeographicalRegionService.createGeographicalRegion(geographicalRegion).then(res =>{
                this.props.history.push('/geographicalRegions');
            });
        }else{
            GeographicalRegionService.updateGeographicalRegion(geographicalRegion).then( res => {
                this.props.history.push('/geographicalRegions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/geographicalRegions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GeographicalRegion</h3>
        }else{
            return <h3 className="text-center">Update GeographicalRegion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGeographicalRegion}>Save</button>
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

export default CreateGeographicalRegionComponent
