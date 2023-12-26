import React, { Component } from 'react'
import DCTopologicalIslandService from '../services/DCTopologicalIslandService'

class ListDCTopologicalIslandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCTopologicalIslands: []
        }
        this.addDCTopologicalIsland = this.addDCTopologicalIsland.bind(this);
        this.editDCTopologicalIsland = this.editDCTopologicalIsland.bind(this);
        this.deleteDCTopologicalIsland = this.deleteDCTopologicalIsland.bind(this);
    }

    deleteDCTopologicalIsland(id){
        DCTopologicalIslandService.deleteDCTopologicalIsland(id).then( res => {
            this.setState({dCTopologicalIslands: this.state.dCTopologicalIslands.filter(dCTopologicalIsland => dCTopologicalIsland.dCTopologicalIslandId !== id)});
        });
    }
    viewDCTopologicalIsland(id){
        this.props.history.push(`/view-dCTopologicalIsland/${id}`);
    }
    editDCTopologicalIsland(id){
        this.props.history.push(`/add-dCTopologicalIsland/${id}`);
    }

    componentDidMount(){
        DCTopologicalIslandService.getDCTopologicalIslands().then((res) => {
            this.setState({ dCTopologicalIslands: res.data});
        });
    }

    addDCTopologicalIsland(){
        this.props.history.push('/add-dCTopologicalIsland/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCTopologicalIsland List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCTopologicalIsland}> Add DCTopologicalIsland</button>
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
                                    this.state.dCTopologicalIslands.map(
                                        dCTopologicalIsland => 
                                        <tr key = {dCTopologicalIsland.dCTopologicalIslandId}>
                                             <td>
                                                 <button onClick={ () => this.editDCTopologicalIsland(dCTopologicalIsland.dCTopologicalIslandId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCTopologicalIsland(dCTopologicalIsland.dCTopologicalIslandId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCTopologicalIsland(dCTopologicalIsland.dCTopologicalIslandId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCTopologicalIslandComponent
