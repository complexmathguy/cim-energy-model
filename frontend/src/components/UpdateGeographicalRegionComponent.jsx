import React, { Component } from 'react'
import GeographicalRegionService from '../services/GeographicalRegionService';

class UpdateGeographicalRegionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGeographicalRegion = this.updateGeographicalRegion.bind(this);

    }

    componentDidMount(){
        GeographicalRegionService.getGeographicalRegionById(this.state.id).then( (res) =>{
            let geographicalRegion = res.data;
            this.setState({
            });
        });
    }

    updateGeographicalRegion = (e) => {
        e.preventDefault();
        let geographicalRegion = {
            geographicalRegionId: this.state.id,
        };
        console.log('geographicalRegion => ' + JSON.stringify(geographicalRegion));
        console.log('id => ' + JSON.stringify(this.state.id));
        GeographicalRegionService.updateGeographicalRegion(geographicalRegion).then( res => {
            this.props.history.push('/geographicalRegions');
        });
    }


    cancel(){
        this.props.history.push('/geographicalRegions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GeographicalRegion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGeographicalRegion}>Save</button>
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

export default UpdateGeographicalRegionComponent
