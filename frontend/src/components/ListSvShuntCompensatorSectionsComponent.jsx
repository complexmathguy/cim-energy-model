import React, { Component } from 'react'
import SvShuntCompensatorSectionsService from '../services/SvShuntCompensatorSectionsService'

class ListSvShuntCompensatorSectionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                svShuntCompensatorSectionss: []
        }
        this.addSvShuntCompensatorSections = this.addSvShuntCompensatorSections.bind(this);
        this.editSvShuntCompensatorSections = this.editSvShuntCompensatorSections.bind(this);
        this.deleteSvShuntCompensatorSections = this.deleteSvShuntCompensatorSections.bind(this);
    }

    deleteSvShuntCompensatorSections(id){
        SvShuntCompensatorSectionsService.deleteSvShuntCompensatorSections(id).then( res => {
            this.setState({svShuntCompensatorSectionss: this.state.svShuntCompensatorSectionss.filter(svShuntCompensatorSections => svShuntCompensatorSections.svShuntCompensatorSectionsId !== id)});
        });
    }
    viewSvShuntCompensatorSections(id){
        this.props.history.push(`/view-svShuntCompensatorSections/${id}`);
    }
    editSvShuntCompensatorSections(id){
        this.props.history.push(`/add-svShuntCompensatorSections/${id}`);
    }

    componentDidMount(){
        SvShuntCompensatorSectionsService.getSvShuntCompensatorSectionss().then((res) => {
            this.setState({ svShuntCompensatorSectionss: res.data});
        });
    }

    addSvShuntCompensatorSections(){
        this.props.history.push('/add-svShuntCompensatorSections/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SvShuntCompensatorSections List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSvShuntCompensatorSections}> Add SvShuntCompensatorSections</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Sections </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.svShuntCompensatorSectionss.map(
                                        svShuntCompensatorSections => 
                                        <tr key = {svShuntCompensatorSections.svShuntCompensatorSectionsId}>
                                             <td> { svShuntCompensatorSections.sections } </td>
                                             <td>
                                                 <button onClick={ () => this.editSvShuntCompensatorSections(svShuntCompensatorSections.svShuntCompensatorSectionsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSvShuntCompensatorSections(svShuntCompensatorSections.svShuntCompensatorSectionsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSvShuntCompensatorSections(svShuntCompensatorSections.svShuntCompensatorSectionsId)} className="btn btn-info btn-sm">View </button>
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

export default ListSvShuntCompensatorSectionsComponent
