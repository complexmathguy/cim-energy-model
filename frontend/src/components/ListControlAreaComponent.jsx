import React, { Component } from 'react'
import ControlAreaService from '../services/ControlAreaService'

class ListControlAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                controlAreas: []
        }
        this.addControlArea = this.addControlArea.bind(this);
        this.editControlArea = this.editControlArea.bind(this);
        this.deleteControlArea = this.deleteControlArea.bind(this);
    }

    deleteControlArea(id){
        ControlAreaService.deleteControlArea(id).then( res => {
            this.setState({controlAreas: this.state.controlAreas.filter(controlArea => controlArea.controlAreaId !== id)});
        });
    }
    viewControlArea(id){
        this.props.history.push(`/view-controlArea/${id}`);
    }
    editControlArea(id){
        this.props.history.push(`/add-controlArea/${id}`);
    }

    componentDidMount(){
        ControlAreaService.getControlAreas().then((res) => {
            this.setState({ controlAreas: res.data});
        });
    }

    addControlArea(){
        this.props.history.push('/add-controlArea/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ControlArea List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addControlArea}> Add ControlArea</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Type </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.controlAreas.map(
                                        controlArea => 
                                        <tr key = {controlArea.controlAreaId}>
                                             <td> { controlArea.type } </td>
                                             <td>
                                                 <button onClick={ () => this.editControlArea(controlArea.controlAreaId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteControlArea(controlArea.controlAreaId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewControlArea(controlArea.controlAreaId)} className="btn btn-info btn-sm">View </button>
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

export default ListControlAreaComponent
