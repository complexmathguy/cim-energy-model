import React, { Component } from 'react'
import VisibilityLayerService from '../services/VisibilityLayerService';

class UpdateVisibilityLayerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                drawingOrder: ''
        }
        this.updateVisibilityLayer = this.updateVisibilityLayer.bind(this);

        this.changedrawingOrderHandler = this.changedrawingOrderHandler.bind(this);
    }

    componentDidMount(){
        VisibilityLayerService.getVisibilityLayerById(this.state.id).then( (res) =>{
            let visibilityLayer = res.data;
            this.setState({
                drawingOrder: visibilityLayer.drawingOrder
            });
        });
    }

    updateVisibilityLayer = (e) => {
        e.preventDefault();
        let visibilityLayer = {
            visibilityLayerId: this.state.id,
            drawingOrder: this.state.drawingOrder
        };
        console.log('visibilityLayer => ' + JSON.stringify(visibilityLayer));
        console.log('id => ' + JSON.stringify(this.state.id));
        VisibilityLayerService.updateVisibilityLayer(visibilityLayer).then( res => {
            this.props.history.push('/visibilityLayers');
        });
    }

    changedrawingOrderHandler= (event) => {
        this.setState({drawingOrder: event.target.value});
    }

    cancel(){
        this.props.history.push('/visibilityLayers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VisibilityLayer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> drawingOrder: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVisibilityLayer}>Save</button>
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

export default UpdateVisibilityLayerComponent
