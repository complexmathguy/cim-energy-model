import React, { Component } from 'react'
import SubGeographicalRegionService from '../services/SubGeographicalRegionService'

class ListSubGeographicalRegionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                subGeographicalRegions: []
        }
        this.addSubGeographicalRegion = this.addSubGeographicalRegion.bind(this);
        this.editSubGeographicalRegion = this.editSubGeographicalRegion.bind(this);
        this.deleteSubGeographicalRegion = this.deleteSubGeographicalRegion.bind(this);
    }

    deleteSubGeographicalRegion(id){
        SubGeographicalRegionService.deleteSubGeographicalRegion(id).then( res => {
            this.setState({subGeographicalRegions: this.state.subGeographicalRegions.filter(subGeographicalRegion => subGeographicalRegion.subGeographicalRegionId !== id)});
        });
    }
    viewSubGeographicalRegion(id){
        this.props.history.push(`/view-subGeographicalRegion/${id}`);
    }
    editSubGeographicalRegion(id){
        this.props.history.push(`/add-subGeographicalRegion/${id}`);
    }

    componentDidMount(){
        SubGeographicalRegionService.getSubGeographicalRegions().then((res) => {
            this.setState({ subGeographicalRegions: res.data});
        });
    }

    addSubGeographicalRegion(){
        this.props.history.push('/add-subGeographicalRegion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SubGeographicalRegion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSubGeographicalRegion}> Add SubGeographicalRegion</button>
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
                                    this.state.subGeographicalRegions.map(
                                        subGeographicalRegion => 
                                        <tr key = {subGeographicalRegion.subGeographicalRegionId}>
                                             <td>
                                                 <button onClick={ () => this.editSubGeographicalRegion(subGeographicalRegion.subGeographicalRegionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSubGeographicalRegion(subGeographicalRegion.subGeographicalRegionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSubGeographicalRegion(subGeographicalRegion.subGeographicalRegionId)} className="btn btn-info btn-sm">View </button>
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

export default ListSubGeographicalRegionComponent
