import React, { Component } from 'react'
import SubGeographicalRegionService from '../services/SubGeographicalRegionService';

class CreateSubGeographicalRegionComponent extends Component {
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
            SubGeographicalRegionService.getSubGeographicalRegionById(this.state.id).then( (res) =>{
                let subGeographicalRegion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSubGeographicalRegion = (e) => {
        e.preventDefault();
        let subGeographicalRegion = {
                subGeographicalRegionId: this.state.id,
            };
        console.log('subGeographicalRegion => ' + JSON.stringify(subGeographicalRegion));

        // step 5
        if(this.state.id === '_add'){
            subGeographicalRegion.subGeographicalRegionId=''
            SubGeographicalRegionService.createSubGeographicalRegion(subGeographicalRegion).then(res =>{
                this.props.history.push('/subGeographicalRegions');
            });
        }else{
            SubGeographicalRegionService.updateSubGeographicalRegion(subGeographicalRegion).then( res => {
                this.props.history.push('/subGeographicalRegions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/subGeographicalRegions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SubGeographicalRegion</h3>
        }else{
            return <h3 className="text-center">Update SubGeographicalRegion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSubGeographicalRegion}>Save</button>
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

export default CreateSubGeographicalRegionComponent
