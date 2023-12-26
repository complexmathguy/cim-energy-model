import React, { Component } from 'react'
import AreaService from '../services/AreaService'

class ListAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                areas: []
        }
        this.addArea = this.addArea.bind(this);
        this.editArea = this.editArea.bind(this);
        this.deleteArea = this.deleteArea.bind(this);
    }

    deleteArea(id){
        AreaService.deleteArea(id).then( res => {
            this.setState({areas: this.state.areas.filter(area => area.areaId !== id)});
        });
    }
    viewArea(id){
        this.props.history.push(`/view-area/${id}`);
    }
    editArea(id){
        this.props.history.push(`/add-area/${id}`);
    }

    componentDidMount(){
        AreaService.getAreas().then((res) => {
            this.setState({ areas: res.data});
        });
    }

    addArea(){
        this.props.history.push('/add-area/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Area List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addArea}> Add Area</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.areas.map(
                                        area => 
                                        <tr key = {area.areaId}>
                                             <td> { area.multiplier } </td>
                                             <td> { area.unit } </td>
                                             <td> { area.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editArea(area.areaId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteArea(area.areaId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewArea(area.areaId)} className="btn btn-info btn-sm">View </button>
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

export default ListAreaComponent
