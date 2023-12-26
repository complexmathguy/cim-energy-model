import React, { Component } from 'react'
import VisibilityLayerService from '../services/VisibilityLayerService';

class CreateVisibilityLayerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                drawingOrder: ''
        }
        this.changedrawingOrderHandler = this.changedrawingOrderHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            VisibilityLayerService.getVisibilityLayerById(this.state.id).then( (res) =>{
                let visibilityLayer = res.data;
                this.setState({
                    drawingOrder: visibilityLayer.drawingOrder
                });
            });
        }        
    }
    saveOrUpdateVisibilityLayer = (e) => {
        e.preventDefault();
        let visibilityLayer = {
                visibilityLayerId: this.state.id,
                drawingOrder: this.state.drawingOrder
            };
        console.log('visibilityLayer => ' + JSON.stringify(visibilityLayer));

        // step 5
        if(this.state.id === '_add'){
            visibilityLayer.visibilityLayerId=''
            VisibilityLayerService.createVisibilityLayer(visibilityLayer).then(res =>{
                this.props.history.push('/visibilityLayers');
            });
        }else{
            VisibilityLayerService.updateVisibilityLayer(visibilityLayer).then( res => {
                this.props.history.push('/visibilityLayers');
            });
        }
    }
    
    changedrawingOrderHandler= (event) => {
        this.setState({drawingOrder: event.target.value});
    }

    cancel(){
        this.props.history.push('/visibilityLayers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VisibilityLayer</h3>
        }else{
            return <h3 className="text-center">Update VisibilityLayer</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> drawingOrder: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVisibilityLayer}>Save</button>
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

export default CreateVisibilityLayerComponent
