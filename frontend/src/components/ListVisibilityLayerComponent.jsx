import React, { Component } from 'react'
import VisibilityLayerService from '../services/VisibilityLayerService'

class ListVisibilityLayerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                visibilityLayers: []
        }
        this.addVisibilityLayer = this.addVisibilityLayer.bind(this);
        this.editVisibilityLayer = this.editVisibilityLayer.bind(this);
        this.deleteVisibilityLayer = this.deleteVisibilityLayer.bind(this);
    }

    deleteVisibilityLayer(id){
        VisibilityLayerService.deleteVisibilityLayer(id).then( res => {
            this.setState({visibilityLayers: this.state.visibilityLayers.filter(visibilityLayer => visibilityLayer.visibilityLayerId !== id)});
        });
    }
    viewVisibilityLayer(id){
        this.props.history.push(`/view-visibilityLayer/${id}`);
    }
    editVisibilityLayer(id){
        this.props.history.push(`/add-visibilityLayer/${id}`);
    }

    componentDidMount(){
        VisibilityLayerService.getVisibilityLayers().then((res) => {
            this.setState({ visibilityLayers: res.data});
        });
    }

    addVisibilityLayer(){
        this.props.history.push('/add-visibilityLayer/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VisibilityLayer List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVisibilityLayer}> Add VisibilityLayer</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> DrawingOrder </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.visibilityLayers.map(
                                        visibilityLayer => 
                                        <tr key = {visibilityLayer.visibilityLayerId}>
                                             <td> { visibilityLayer.drawingOrder } </td>
                                             <td>
                                                 <button onClick={ () => this.editVisibilityLayer(visibilityLayer.visibilityLayerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVisibilityLayer(visibilityLayer.visibilityLayerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVisibilityLayer(visibilityLayer.visibilityLayerId)} className="btn btn-info btn-sm">View </button>
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

export default ListVisibilityLayerComponent
