import React, { Component } from 'react'
import GeographicalRegionService from '../services/GeographicalRegionService'

class ListGeographicalRegionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                geographicalRegions: []
        }
        this.addGeographicalRegion = this.addGeographicalRegion.bind(this);
        this.editGeographicalRegion = this.editGeographicalRegion.bind(this);
        this.deleteGeographicalRegion = this.deleteGeographicalRegion.bind(this);
    }

    deleteGeographicalRegion(id){
        GeographicalRegionService.deleteGeographicalRegion(id).then( res => {
            this.setState({geographicalRegions: this.state.geographicalRegions.filter(geographicalRegion => geographicalRegion.geographicalRegionId !== id)});
        });
    }
    viewGeographicalRegion(id){
        this.props.history.push(`/view-geographicalRegion/${id}`);
    }
    editGeographicalRegion(id){
        this.props.history.push(`/add-geographicalRegion/${id}`);
    }

    componentDidMount(){
        GeographicalRegionService.getGeographicalRegions().then((res) => {
            this.setState({ geographicalRegions: res.data});
        });
    }

    addGeographicalRegion(){
        this.props.history.push('/add-geographicalRegion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GeographicalRegion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGeographicalRegion}> Add GeographicalRegion</button>
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
                                    this.state.geographicalRegions.map(
                                        geographicalRegion => 
                                        <tr key = {geographicalRegion.geographicalRegionId}>
                                             <td>
                                                 <button onClick={ () => this.editGeographicalRegion(geographicalRegion.geographicalRegionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGeographicalRegion(geographicalRegion.geographicalRegionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGeographicalRegion(geographicalRegion.geographicalRegionId)} className="btn btn-info btn-sm">View </button>
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

export default ListGeographicalRegionComponent
