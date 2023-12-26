import React, { Component } from 'react'
import SubLoadAreaService from '../services/SubLoadAreaService'

class ListSubLoadAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                subLoadAreas: []
        }
        this.addSubLoadArea = this.addSubLoadArea.bind(this);
        this.editSubLoadArea = this.editSubLoadArea.bind(this);
        this.deleteSubLoadArea = this.deleteSubLoadArea.bind(this);
    }

    deleteSubLoadArea(id){
        SubLoadAreaService.deleteSubLoadArea(id).then( res => {
            this.setState({subLoadAreas: this.state.subLoadAreas.filter(subLoadArea => subLoadArea.subLoadAreaId !== id)});
        });
    }
    viewSubLoadArea(id){
        this.props.history.push(`/view-subLoadArea/${id}`);
    }
    editSubLoadArea(id){
        this.props.history.push(`/add-subLoadArea/${id}`);
    }

    componentDidMount(){
        SubLoadAreaService.getSubLoadAreas().then((res) => {
            this.setState({ subLoadAreas: res.data});
        });
    }

    addSubLoadArea(){
        this.props.history.push('/add-subLoadArea/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SubLoadArea List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSubLoadArea}> Add SubLoadArea</button>
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
                                    this.state.subLoadAreas.map(
                                        subLoadArea => 
                                        <tr key = {subLoadArea.subLoadAreaId}>
                                             <td>
                                                 <button onClick={ () => this.editSubLoadArea(subLoadArea.subLoadAreaId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSubLoadArea(subLoadArea.subLoadAreaId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSubLoadArea(subLoadArea.subLoadAreaId)} className="btn btn-info btn-sm">View </button>
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

export default ListSubLoadAreaComponent
