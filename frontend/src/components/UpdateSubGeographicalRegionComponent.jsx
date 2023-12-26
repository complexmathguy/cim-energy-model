import React, { Component } from 'react'
import SubGeographicalRegionService from '../services/SubGeographicalRegionService';

class UpdateSubGeographicalRegionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSubGeographicalRegion = this.updateSubGeographicalRegion.bind(this);

    }

    componentDidMount(){
        SubGeographicalRegionService.getSubGeographicalRegionById(this.state.id).then( (res) =>{
            let subGeographicalRegion = res.data;
            this.setState({
            });
        });
    }

    updateSubGeographicalRegion = (e) => {
        e.preventDefault();
        let subGeographicalRegion = {
            subGeographicalRegionId: this.state.id,
        };
        console.log('subGeographicalRegion => ' + JSON.stringify(subGeographicalRegion));
        console.log('id => ' + JSON.stringify(this.state.id));
        SubGeographicalRegionService.updateSubGeographicalRegion(subGeographicalRegion).then( res => {
            this.props.history.push('/subGeographicalRegions');
        });
    }


    cancel(){
        this.props.history.push('/subGeographicalRegions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SubGeographicalRegion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSubGeographicalRegion}>Save</button>
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

export default UpdateSubGeographicalRegionComponent
